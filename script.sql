USE [bootcampfinal]
GO
/****** Object:  Table [dbo].[company]    Script Date: 8/15/2022 6:03:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[company](
	[id] [int] NOT NULL,
	[name] [varchar](150) NULL,
	[ruc] [varchar](20) NULL,
	[description] [varchar](150) NULL,
 CONSTRAINT [PK_company] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[configuration]    Script Date: 8/15/2022 6:03:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[configuration](
	[id] [int] NOT NULL,
	[name] [varchar](150) NULL,
	[description] [varchar](150) NULL,
	[date_configuration] [datetime] NULL,
	[amountmin] [decimal](18, 4) NULL,
	[amountmax] [decimal](18, 4) NULL,
	[status] [bit] NULL,
	[comapny_id] [int] NULL,
 CONSTRAINT [PK_configuration] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[person]    Script Date: 8/15/2022 6:03:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[person](
	[id] [int] NOT NULL,
	[name] [varchar](150) NULL,
	[lastname] [varchar](150) NULL,
	[document] [varchar](10) NULL,
	[user_id] [int] NULL,
 CONSTRAINT [PK_person] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[procedure]    Script Date: 8/15/2022 6:03:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[procedure](
	[id] [int] NOT NULL,
	[name] [varchar](150) NULL,
	[description] [varchar](150) NULL,
	[dateProcedure] [datetime] NULL,
	[status] [char](1) NULL,
	[company_id] [int] NULL,
	[amount] [decimal](18, 4) NULL,
	[user_id] [int] NULL,
 CONSTRAINT [PK_procedure] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 8/15/2022 6:03:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varbinary](150) NULL,
	[password] [varbinary](150) NOT NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[configuration]  WITH CHECK ADD  CONSTRAINT [FK_configuration_company] FOREIGN KEY([comapny_id])
REFERENCES [dbo].[company] ([id])
GO
ALTER TABLE [dbo].[configuration] CHECK CONSTRAINT [FK_configuration_company]
GO
ALTER TABLE [dbo].[person]  WITH CHECK ADD  CONSTRAINT [FK_person_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[person] CHECK CONSTRAINT [FK_person_user]
GO
ALTER TABLE [dbo].[procedure]  WITH CHECK ADD  CONSTRAINT [FK_procedure_company] FOREIGN KEY([company_id])
REFERENCES [dbo].[company] ([id])
GO
ALTER TABLE [dbo].[procedure] CHECK CONSTRAINT [FK_procedure_company]
GO
ALTER TABLE [dbo].[procedure]  WITH CHECK ADD  CONSTRAINT [FK_procedure_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[procedure] CHECK CONSTRAINT [FK_procedure_user]
GO
